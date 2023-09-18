import axios from "axios";

export const getAllDepartment=()=>{
    return axios.get("http://localhost:8080/department/getall");
}

export const addDepartment=(department)=>{
    return axios.post("http://localhost:8080/department/add",department ,{
        // withCredentials: true,
        headers:{
            // 'Content-Type': 'application/json',
            // 'Access-Control-Allow-Origin': '*',
            // 'Access-Control-Allow-Headers': '*',
            // 'Access-Control-Allow-Credentials': true,
            email:'adarsh123@gmail.com',
            password:'adarsh'
        }
        
    });
}

export const deleteDepartmentById=(id)=>{
    console.log(id);
    return axios.delete(`http://localhost:8080/department/delete/${id}`);
}