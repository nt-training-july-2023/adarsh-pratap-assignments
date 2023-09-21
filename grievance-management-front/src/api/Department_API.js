import { headers } from "./Headers";
import { deleteMapping, getMapping, postMapping } from "./AllUrls";

export const getAllDepartment=()=>{
    return getMapping(`/department/getall`,{headers:headers()})
}
export const addDepartment=(department)=>{
    return postMapping(`/department/add`,department ,{headers:headers()});
}

export const deleteDepartmentById=(id)=>{
    return deleteMapping(`/department/delete/${id}`,{headers:headers()});
}