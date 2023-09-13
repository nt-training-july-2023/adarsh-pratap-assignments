import React from 'react'
import "./Department.css"
import { useEffect } from 'react';
import { getAllDepartment } from '../api/Department_API';
import { useState } from 'react';




function Department() {
    const [dep , setDep] = useState([]);

    useEffect(()=>{
        getAllDepartment().then(resp=>{
            setDep(resp.data);
            console.log(dep)
        })
    },[])
  return (
    <div className='department-table'>
    <table>
  <tr>
    <th>S.No.</th>
    <th>Department</th>
    <th>Actions</th>
  </tr>

  {dep.map(d=>{
       return (
            <tr>
                <td>{d.depId}</td>
                <td>{d.depName}</td>
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