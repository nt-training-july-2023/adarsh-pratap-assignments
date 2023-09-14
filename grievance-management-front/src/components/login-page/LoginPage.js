import React, { useState } from 'react'
import "./LoginPage.css"
import { useNavigate } from 'react-router-dom';
import { login } from '../../api/Employee_API';
function LoginPage() {

    const navigate = useNavigate(); 

    const [data , setData] = useState({
        userName:'',
        password:''
      });
    
      const [valid , setValid] = useState({
        userName:{
            isError:false,
            errorMessage:""
        },
        password:{
            isError:false,
            errorMessage:""
        }
      })
    
      const handleChange=(e)=>{
        if(valid.userName.isError || valid.password.isError){
            const temp = {...valid};

            temp.userName.isError = false;
            temp.password.isError = false;

            setValid(temp);
        }
        setData({
            ...data , 
            [e.target.name] : e.target.value
        })
      }
      
      const handleSubmit=(e)=>{
        e.preventDefault();
        validation();
        if(!valid.userName.isError && !valid.password.isError){
            login(data).then(res=>{
                alert("Welcome "+res.data.role);
            }).catch(error=>{
                alert("Invalid User")
        })
    }
    }

        const validation=()=>{
            const regex = /^[A-Za-z0-9._%+-]+@nucleusteq\.com$/;
            if(!regex.test(data.userName)){
                const temp = {...valid};

                temp.userName.isError=true;
                temp.userName.errorMessage="Email ends with @nucleusteq.com"

                setValid(temp);
            }

            if(data.password.length < 5 || data.password.length > 15){
                const temp = {...valid};

                temp.password.isError=true;
                temp.password.errorMessage="length of password is between 5 to 15"

                setValid(temp);
            } 
        }

  return (
    <div className='outer-div'>
        <div className='image-box'>
            <img src='./logo.png'/>
        </div>
        <div className="content-box">
            <div className='form-box'>
                <h2>
                    Login!
                </h2>
                <form onSubmit={handleSubmit}>
                    <div className='input-box'>
                        <span>UserName</span>
                        <input type = "email" name="userName" value={data.userName} onChange={handleChange} required/>
                        {valid.userName.isError && (<p>{valid.userName.errorMessage}</p>)}
                    </div>
                    <div className='input-box'>
                        <span>Password</span>
                        <input type='password' name="password" value={data.password} onChange={handleChange} required/>
                        {valid.password.isError && (<p>{valid.password.errorMessage}</p>)}
                    </div>
                    <div className='input-box'>
                        <input type='submit' value='Sign in'  />
                    </div>
                </form>
            </div>
        </div>
    </div>
  )
}

export default LoginPage