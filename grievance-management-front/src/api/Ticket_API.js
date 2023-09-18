import axios from "axios";

export const addTicket=(ticket)=>{
    return axios.post("http://localhost:8080/ticket/add" , ticket);
}

// export const getTicket=(ticket)=>{
//     return axios.post("http://localhost:8080/ticket/getall/{}/{}" );
// }