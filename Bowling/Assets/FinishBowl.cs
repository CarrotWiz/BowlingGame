using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class FinishBowl : MonoBehaviour
{
    [SerializeField] private GameObject endBlock;

    private IEnumerator OnCollisionEnter(Collision collision)
    {
        Debug.Log(collision.collider.tag == endBlock.tag);
        if(collision.collider.tag == endBlock.tag)
        {
            yield return new WaitForSeconds(2);
            Application.Quit();
        }
    }
}
