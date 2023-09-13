import axios from "axios";

export const login=(data)=>{
    return axios.post("http://localhost:8080/employee/login",data);
}