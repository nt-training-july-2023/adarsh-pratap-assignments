import axios from "axios";

export const getAllDepartment=()=>{
    return axios.get("http://localhost:8080/department/getall");
}