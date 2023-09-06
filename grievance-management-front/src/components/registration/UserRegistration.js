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
    },
    department:{
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
    
    if(valid.userName.isError || valid.email.isError || valid.password.isError || valid.role.isError){
      let state = {...valid}

      state.userName.isError = false;
      state.email.isError = false;
      state.password.isError = false;
      state.role.isError = false;
      state.department.isError = false;
      setValid(state);
    }


    setEmployee({...employee , [e.target.name] : e.target.value});
    
  }

  const handleSelectChange=(e)=>{
    const selectedObjectId = parseInt(e.target.value, 10);
    
    // Find the selected object based on its ID
    const selectedObject = this.department.find(
      (obj) => obj.id === selectedObjectId);

      console.log(selectedObject)
    
  }

 

  const isValid=()=>{

    console.log(employee);

    if(employee.userName === ""){
      let newState = {...valid};

      newState.userName.isError = true;
      newState.userName.errorMessage = "Username can not be empty";

      setValid(newState);
    }
    
    if(employee.password === "" ){
      let newState = {...valid};

      newState.password.isError = true;
      newState.password.errorMessage = "Password can not be empty"

      setValid(newState);
      
    }
    const regex = /^[a-z0-9](\.?[a-z0-9]){5,}@g(oogle)?mail\.com$/;
    if(!regex.test(employee.email)){
      let newState = {...valid};

      newState.email.isError = true;
      newState.email.errorMessage = "Email can not be empty and ends with @google.com";

      setValid(newState);
    }

    if(employee.role === ""){
      let newState = {...valid};

      newState.role.isError = true;
      newState.role.errorMessage = "Select Role";

      setValid(newState);
      
    }

    if(employee.department === ""){
      let newState = {...valid};

      newState.department.isError = true;
      newState.department.errorMessage = "Select Department";

      setValid(newState);
      console.log("Inside valid department")
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
            {valid.userName.isError ?  (<p>{valid.userName.errorMessage}</p>) : null}
          </div>
          <div className='inner-div'>
            <label>Email</label>
            <input type='email' placeholder='Enter your email' name='email' value={employee.email} onChange={handleChange} />
            {valid.email.isError ?  (<p>{valid.email.errorMessage}</p>) : null}
          </div>
          <div className='inner-div'>
            <label>Password</label>
            <input type='password' placeholder='Enter your password' name='password' value={employee.password} onChange={handleChange} />
            {valid.password.isError ?  (<p>{valid.password.errorMessage}</p>) : null}
          </div>
          <div className='inner-div'>
            <label>Role:</label>

            <select name="role" defaultValue="" value={employee.role} onChange={handleChange}>
            <option value="">--Select--</option>
              <option value="ROLE_ADMIN">ADMIN</option>
              <option value="ROLE_USER">USER</option>
            </select>
            {valid.role.isError ?  (<p>{valid.role.errorMessage}</p>) : null}
          </div>



          <div className='inner-div'>

            <label>Department:</label>

            <select name="department" defaultValue="" value={employee.department} onChange={handleChange} >
              <option value="" >--Select--</option>
              {department.map(dep=>{
                  // console.log(dep)
                  return <option  value={dep.depName}>{dep.depName}</option>
              })}
            </select>

            {valid.department.isError ?  (<p>{valid.department.errorMessage}</p>) : null}
          
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