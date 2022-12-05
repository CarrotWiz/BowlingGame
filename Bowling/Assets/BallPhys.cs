using System.Collections;
using System.Collections.Generic;
using UnityEngine.InputSystem;
using UnityEngine;

public class BallPhys : MonoBehaviour
{
    private float holdStartTime;
    private bool isBowl = false;
    public Rigidbody rb;

    // Start is called before the first frame update
    void Start()
    {
        holdStartTime = 0f;
        rb = GetComponent<Rigidbody>();
        rb.useGravity = false;

        
        InputSystem.EnableDevice(Accelerometer.current);
        InputSystem.EnableDevice(AttitudeSensor.current);
        InputSystem.EnableDevice(GravitySensor.current);
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetMouseButtonDown(0))
        {
            holdStartTime = Time.time;
        }

        if (Input.GetMouseButtonUp(0))
        {
            float holdTime = Time.time - holdStartTime;

            if (!isBowl)
            {
                isBowl = true;

                Bowl(holdTime);
            }
        }

    }

    void Bowl(float htime)
    {
        float maxF = 100000f;

        float normHold = Mathf.Clamp01(htime/maxF);
        float force = normHold * maxF;

        Vector3 acceleration = Accelerometer.current.acceleration.ReadValue();
        Vector3 direction = acceleration.normalized;


        rb.AddForce(30f*direction[2], 30f*direction[0], 50f*direction[1], ForceMode.Impulse);
        //rb.AddForce(0, 0, 50f, ForceMode.Impulse);
        //rb.AddTorque(5000f, 1000f, 0, ForceMode.Impulse);

        //rb.transform.RotateAround(rb.transform.position, transform.left, 50f);
        Quaternion deltaRotation = Quaternion.Euler((new Vector3(1000, 1000, 1000)) * Time.fixedDeltaTime);
        rb.MoveRotation(rb.rotation * deltaRotation);

        rb.useGravity = true;

    }
}
