import React, { useState } from "react";
import "./Modal.css";
import axios from "axios";
import { addDepartment } from "../../api/Department_API";
import { useNavigate } from "react-router-dom";

export default function Modal(props) {

    const navigate = useNavigate();
    const [department , setDepartment] = useState({
        depName:""
    });

    const [valid , setValid] = useState({
        isError:false,
        errorMessage:""
    })

    const handleChange=(e)=>{
        if(valid.isError){
            setValid({
                ...valid,
                isError:false
            })
        }
        setDepartment({...department , [e.target.name] : e.target.value});
    }

    const isValid=()=>{
        if(department.depName === ""){
            setValid({
                ...valid , 
                isError:true,
                errorMessage:"Depatment name can not be empty"
            })
        }
    }

    const handleSubmit=(e)=>{
        e.preventDefault();
        isValid();
        if(!valid.isError){
            addDepartment(department).then(resp=>{
                alert("Depatment is Added!!");
            }).catch(error=>{
                console.log(error);
                alert(error.response.data)
        })
        }
        return;
    }

    return (
        <>
        <div className="modal" >
            <div className="overlay" onClick={()=>{navigate("/addticket")}}></div>
          <div className="modal-content">
            <div className="header">
            <span>Add Department</span>
            </div>
                <form onSubmit={handleSubmit}>
                    <div className="details">
                    <label>
                        Department Name :
                    </label>
                    <input type="text" name="depName" value={department.depName} placeholder="Enter the Depatment name" onChange={handleChange}/>
                    {valid.isError && (<p>{valid.errorMessage}</p>)}
                    </div>

                    <div className='submit-box'>
                            <input type='submit' value='Submit'  />
                    </div>
                </form>
            
            {/* <button className="close-modal" onClick={()=>{props.setModal(false)}}>
              X
            </button> */}
          </div>
        </div>
      
    </>
  );
}