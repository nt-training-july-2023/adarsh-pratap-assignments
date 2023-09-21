import React, { useEffect, useState } from "react";
import "../components/Department.css";
import axios from "axios";
import TableHeader from "../components/Table/TableHeader";
import Content from "../components/Table/Content";
import UpdateTicket from "./UpdateTicket";
import { allTicket } from "../api/Ticket_API";

function AllTickets() {
  const [ticket, setTicket] = useState([]);
  const [selectedStatus , setSelectedStatus] = useState("all");
  const [offset , setOffset] = useState(0);
  const [filter , setFilter] = useState("all");

  const [isUpdate , setUpdate] = useState(false);

  const params={empid:19,ticket:filter,filter:selectedStatus,offset:offset};

  useEffect(() => {
      allTicket(params)
      .then((resp) => {
        if(resp.data.length === 0){
          alert("No more data found")
          setOffset((prev)=>prev-1);
        }
        setTicket(resp.data);
      });
  },[offset, selectedStatus, filter]);

  
  const header = [
    "Ticket Id",
    "Ticket Type",
    "Status",
    "Ticket Title",
    "Last Update",
    "Actions",
  ];

  const handleStatusChange=(e)=>{
    setOffset(0);
    setSelectedStatus(e.target.value);
  }

  const handleFilterChange=(e)=>{
    setOffset(0);
    setFilter(e.target.value);
  }

  return (
    <>
    {isUpdate && (<UpdateTicket setUpdate={setUpdate}/>)}
    <div className="department-table">
      <div>
        <h1>All Tickets</h1>
      </div>
      <div>
      <div>
        <label>Status:</label>

        <select name="status" defaultValue="all" value={selectedStatus} onChange={handleStatusChange}>
          <option value="all">ALL TICKETS</option>
          <option value="open">OPEN</option>
          <option value="progress">BEING_ADDRESSED</option>
          <option value="resolved">RESOLVED</option>
        </select>
      </div>

      <div>
        <label>Ticket:</label>

        <select name="filter" defaultValue="all" value={filter} onChange={handleFilterChange}>
          <option value="all">ALL TICKETS</option>
          <option value="department">My Department</option>
          <option value="my">My Tickets</option>
        </select>
      </div>
      </div>
      <table>
        <TableHeader header={header} />

        {ticket.map((d) => {
          return (
            <tr>
              <Content data={d.ticketId} />
              <Content data={d.ticketType} />
              <Content data={d.status} />
              <Content data={d.ticketName} />
              <Content data={d.lastUpdateDate} />
              <td>
                <button onClick={()=>{setUpdate(true)}}>View</button>
              </td>
            </tr>
          );
        })}
      </table>
      <div>
        <button disabled={offset===0} onClick={()=>{setOffset(offset-1)}}>previous</button>
        <button disabled={ticket.length === 0} onClick={()=>{setOffset(offset+1)}}>Next</button>
      </div>
    </div>
    </>
  );
}

export default AllTickets;
