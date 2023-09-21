import { headers } from "./Headers";
import { getMapping, postMapping } from "./AllUrls";

export const addTicket=(ticket)=>{
    return postMapping(`/ticket/add` , ticket , {headers:headers()});
}

export const allTicket=(params)=>{
    return getMapping(`/ticket/getall`,{params:params,headers:headers(),})
}

