import axios from "axios";
import { headers } from "./Headers";
import { postMapping } from "./AllUrls";

export const login=(data)=>{
    return postMapping(`/employee/login`,data,{});
}

export const changePassword=(id , data)=>{
    return postMapping(`/employee/changepass/${id}`,data,{headers:headers()});
}