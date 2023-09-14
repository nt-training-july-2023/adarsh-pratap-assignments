import axios from "axios";

export const addTicket=(ticket)=>{
    return axios.post("http://localhost:8080/ticket/add" , ticket);
}