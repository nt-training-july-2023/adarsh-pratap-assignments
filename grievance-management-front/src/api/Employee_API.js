import axios from "axios";
import { headers } from "./Headers";
import { deleteMapping, getMapping, postMapping, putMapping } from "./AllUrls";

export const login=(data)=>{
    return postMapping(`/employee/login`,data,{});
}

export const changePassword=(id , data)=>{
    return putMapping(`/employee/changepass/${id}`,data,{headers:headers()});
}

export const getAllEmployee=(params)=>{
    return getMapping(`/employee/getall` , {params:params,headers:headers(),});
}

export const addEmployee=(emp)=>{
    return postMapping(`/employee/add`,emp , {headers:headers()});
}

export const deleteEmployee=(id)=>{
    return deleteMapping(`/employee/delete/${id}` , {headers:headers()});
}
