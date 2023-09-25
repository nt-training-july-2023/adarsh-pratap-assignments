import axios from "axios";
import { headers } from "./Headers";
import { getMapping, postMapping, putMapping } from "./AllUrls";

export const login=(data)=>{
    return postMapping(`/employee/login`,data,{});
}

export const changePassword=(id , data)=>{
    return putMapping(`/employee/changepass/${id}`,data,{headers:headers()});
}

export const getAllEmployee=(params)=>{
    return getMapping(`/employee/getall` , {params:params,headers:headers(),});
}