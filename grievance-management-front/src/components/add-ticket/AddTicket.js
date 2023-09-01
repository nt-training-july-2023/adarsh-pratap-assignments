import React, { useEffect, useState } from 'react'
import "../registration/UserRegistration.css"
import { getAllDepartment } from '../../api/Department_API';

function AddTicket() {

    const [department , setDepartment] = useState([]);

    const [ticket , setTicket] = useState({
        ticketName:"",
        discription:"",
        status:"OPEN",
        ticketType:"",
        department:{},
        employee:""
    })

    const getDepartment=()=>{
    getAllDepartment().then((resp)=>{
      setDepartment(resp.data);
      console.log(resp.data);
    }).catch((error)=>{
      console.log(error);
    })
    }

    useEffect(()=>{
    getDepartment();
    } , [])

    const handleChange=(e)=>{
        setTicket({...ticket , [e.target.name] : e.target.value})
        // console.log(e.target.name + " " + e.target.value);
        // console.log(ticket)
    }
  return (
    <div className='registration'>
      <div className='content'>
      <div className='header'>
        <h1>Add Ticket</h1>
      </div>
      
        <form onSubmit={(e)=>{e.preventDefault();console.log(ticket)}}>
        <div className='user-details'>
        <div className='inner-div'>
            <label>Ticket Type:</label>

            <select name="ticketType" value={ticket.ticketType} onChange={handleChange} defaultValue="">
              <option value="" disabled>--Select--</option>
              <option value="GRIEVANCE">Grievance</option>
              <option value="FEEDBACK">Feedback</option>
            </select>
          </div>
          <div className='inner-div'>
            <label>Title</label>
            <input type='text' placeholder='Enter Title' name='ticketName' value={ticket.ticketName} onChange={handleChange} />
          </div>

          <div className='inner-div'>
            <label>Discription</label>
            <textarea id="" name="discription" placeholder='Enter Discription' rows="4" cols="50"  value={ticket.discription} onChange={handleChange}/>
          </div>

          <div className='inner-div'>
            <label >Department:</label>

            <select name="department" defaultValue="" value={ticket.department} onChange={handleChange}>
            <option value="" disabled>--Select--</option>
              {department.map(dep=>{
                  return <option value={dep}>{dep.depName}</option>
              })}
              {/* <option value="saab">fired</option> */}
            </select>
          </div>
          <div className='inner-div'>
            <label>Status</label>
            <input type='text' value='OPEN' disabled/>
          </div>
          
          <div className='submit-box'>
                <input type='submit' value='Submit'  />
          </div>

          </div>
        </form>
        </div>
    </div>
  )
}

export default AddTicket