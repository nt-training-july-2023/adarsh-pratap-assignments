import { headers } from "./Headers";
import { getMapping, postMapping, putMapping } from "./AllUrls";

export const addTicket=(ticket)=>{
    return postMapping(`/ticket/add` , ticket , {headers:headers()});
}

export const allTicket=(params)=>{
    return getMapping(`/ticket/getall`,{params:params,headers:headers(),});
}

export const getTicketById=(id)=>{
    return getMapping(`/ticket/get/${id}`,{headers:headers()});
}

export const updateTicket=(ticketId,data)=>{
    return putMapping(`/ticket/update/${ticketId}`,data,{headers:headers()});
}