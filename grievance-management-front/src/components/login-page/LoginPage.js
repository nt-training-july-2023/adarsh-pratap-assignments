import React, { useState } from 'react'
import "./LoginPage.css"
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
function LoginPage() {

    const navigate = useNavigate(); 

    const [data , setData] = useState({
        userName:'',
        password:''
      });

      const [message , setMessage] = useState({
        field:'',
        discription:''
      })
    
      const handleChange=(e)=>{
        setData({...data , [e.target.name]: e.target.value});
        // console.log(data);
      }
    
      
      const handleSubmit=(e)=>{
        e.preventDefault();
        const isValid = validation(e);
   
        if(isValid){
        axios.post("http://localhost:8080/login",data)
        .then(response=>{
          if(response.data !== 'Invalid User')
            navigate('/welcome')
        //   else{alert(response.data)}
        }).catch(e=>{
            alert(e.response.data);
        })
        }
        else{
            console.log(message.field)
            alert(message.field + " : " + message.discription);
        }
    }

        const validation=(e)=>{
            e.preventDefault();
            const regex = /^[a-z0-9](\.?[a-z0-9]){5,}@g(oogle)?mail\.com$/;
            if(!regex.test(data.userName)){
            
               
                
                setMessage({...message ,field:"email" , discription:"email incorrect"})
                
                console.log(message)
                return false;
            }

            if(data.password.length < 5 && data.password.length > 15){
                setMessage({...message , [message.field] : "password"})
                setMessage({...message , [message.discription] : "password length range should be between 5 to 15 ."})
                return false;
            } 

            return true;
   
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
                    </div>
                    <div className='input-box'>
                        <span>Password</span>
                        <input type='password' name="password" value={data.password} onChange={handleChange} required/>
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