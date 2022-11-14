using System.Collections;
using System.Collections.Generic;
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

        rb.AddForce(0, 0, 50f, ForceMode.Impulse);

        rb.useGravity = true;

    }
}
