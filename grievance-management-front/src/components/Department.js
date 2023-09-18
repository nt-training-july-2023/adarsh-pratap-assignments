import React from 'react'
import "./Department.css"
import { useEffect } from 'react';
import { useState } from 'react';
import axios from 'axios';




function Department() {
    const [dep , setDep] = useState([]);

    useEffect(()=>{
        axios.get(`http://localhost:8080/ticket/getall/${1}/${"hr"}`).then(resp=>{
            setDep(resp.data);
            
        })
    },[])
  return (
    <div className='department-table'>
    <table>
  <tr>
    <th>Ticket Id</th>
    <th>Ticket Type</th>
    <th>Status</th>
    <th>Ticket Title</th>
    <th>Last Update</th>
    <th>Actions</th>
  </tr>

  {dep.map(d=>{
       return (
            <tr>
                <td>{d.ticketId}</td>
                <td>{d.ticketType}</td>
                <td>{d.status}</td>
                <td>{d.ticketName}</td>
                <td>{d.lastUpdateDate}</td>
                <td>
                    <button>
                        Delete
                    </button>

                    <button>
                        Update
                    </button>
                </td>
            </tr>
    )})}
  
  
</table>
    </div>
  )
}

export default Department