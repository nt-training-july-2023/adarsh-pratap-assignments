import React, { useEffect, useState } from 'react'
import "./UserRegistration.css"
import { getAllDepartment } from '../../api/Department_API';


function UserRegistration() {

  const [department , setDepartment] = useState([]);

  const [employee , setEmployee] = useState({
    userName:"",
    email:"",
    password:"",
    role:"",
    department:{
      depName:"",
      employee:[],
      ticket:[]
    }
  })

  const [valid , setValid] = useState({
    userName:{
      isError:false,
      errorMessage:""
    },
    email:{
      isError:false,
      errorMessage:""
    },
    password:{
      isError:false,
      errorMessage:""
    },
    role:{
      isError:false,
      errorMessage:""
    }
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
    // console.log(JSON.parse(e.target.value))
    setEmployee({...employee , [e.target.name] : e.target.value});
    console.log(employee)
  }

  const handleSelectChange=(e)=>{
    console.log(e.target)
    console.log(e.target.value)
    setEmployee({...employee , department : JSON.parse(e.target.value)});
    // setEmployee
    
  }

  const isValid=()=>{
    
    if(employee.password === "" ){
      const obj = {
        isError:true,
        errorMessage:"Password can not be empty"
      }
      setValid({...valid , password : obj});
    }
    const regex = /^[a-z0-9](\.?[a-z0-9]){5,}@g(oogle)?mail\.com$/;
    if(!regex.test(employee.email)){
      const obj = {
        isError:true,
        errorMessage:"Email should end with @google.com"
      }
      setValid({...valid , email : obj});
    }

    if(employee.role === ""){
      const obj = {
        isError:true,
        errorMessage:"Role can not be empty"
      }
      setValid({...valid , role : obj});
    }
    if(employee.userName === ""){
      const obj = {
        isError:true,
        errorMessage:"Field can not be empty"
      }
      setValid({...valid , userName : obj});
      // console.log(valid)
    }

  }

  const handleSubmit=(e)=>{
    e.preventDefault();
    // console.log(valid);
    isValid();
    console.log(valid)
  }

  return (
    <div className='registration'>
      <div className='content'>
      <div className='header'>
        <h1>User-Registration</h1>
      </div>
      
        <form onSubmit={handleSubmit}>
        <div className='user-details'>
          <div className='inner-div'>
            <label>Username</label>
            <input type='text' placeholder='Enter your name' name='userName' value={employee.userName} onChange={handleChange}/>
            <p>{valid.userName.errorMessage}</p>
          </div>
          <div className='inner-div'>
            <label>Email</label>
            <input type='email' placeholder='Enter your email' name='email' value={employee.email} onChange={handleChange} />
          </div>
          <div className='inner-div'>
            <label>Password</label>
            <input type='password' placeholder='Enter your password' name='password' value={employee.password} onChange={handleChange} />
          </div>
          <div className='inner-div'>
            <label>Role:</label>

            <select name="role" defaultValue="" value={employee.role} onChange={handleChange}>
            <option value="">--Select--</option>
              <option value="ROLE_ADMIN">ADMIN</option>
              <option value="ROLE_USER">USER</option>
            </select>
            <p>{valid.role.errorMessage}</p>
          </div>

          <div className='inner-div'>
            <label>Department:</label>

            <select name="department" defaultValue="" value={department} onChange={handleSelectChange} >

            <option value="" disabled>--Select--</option>
              {department.map(dep=>{
                  console.log(dep)
                  return <option  value={JSON.stringify(dep)}>{dep.depName}</option>
              })}
              
              {/* <option value="saab">fired</option> */}
            </select>
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

export default UserRegistration