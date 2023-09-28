import { headers } from "./Headers";
import { deleteMapping, getMapping, postMapping } from "./AllUrls";

export const getAllDepartment=(params)=>{
    return getMapping(`/department/getall`,{params:params , headers:headers()})
}
export const addDepartment=(department)=>{
    return postMapping(`/department/add`,department ,{headers:headers()});
}

export const deleteDepartmentById=(id)=>{
    return deleteMapping(`/department/delete/${id}`,{headers:headers()});
}