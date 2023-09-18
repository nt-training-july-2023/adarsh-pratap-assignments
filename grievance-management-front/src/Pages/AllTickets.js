import React, { useEffect, useState } from "react";
import "../components/Department.css";
import axios from "axios";
import TableHeader from "../components/Table/TableHeader";
import Content from "../components/Table/Content";

function AllTickets() {
  const [ticket, setTicket] = useState([]);
  const [selectedStatus , setSelectedStatus] = useState("ALL");
  const [filteredTickets, setFilteredTickets] = useState([]);

  useEffect(() => {
    axios
      .get(`http://localhost:8080/ticket/getall/${1}/${"department"}`)
      .then((resp) => {
        setFilteredTickets(resp.data);
        setTicket(resp.data);
      });
  },[]);

  // FILTER BY STATUS
  const handleSelectChange = (event) => {
    const newSelectedStatus = event.target.value;
    setSelectedStatus(newSelectedStatus);
    if (newSelectedStatus === "ALL") {
      setFilteredTickets(ticket);
    } else {
      setFilteredTickets(
        ticket.filter((tick) => tick.status === newSelectedStatus)
      );
    }
    console.log("FILTERED TICKETS BY " + newSelectedStatus);
    console.log(filteredTickets);
  };

  const header = [
    "Ticket Id",
    "Ticket Type",
    "Status",
    "Ticket Title",
    "Last Update",
    "Actions",
  ];

  return (
    <div className="department-table">
      <div>
        <h1>All Tickets</h1>
      </div>
      <div>
        <label>Status:</label>

        <select name="status" defaultValue="ALL" value={selectedStatus} onChange={handleSelectChange}>
          <option value="ALL">ALL TICKETS</option>
          <option value="OPEN">OPEN</option>
          <option value="BEING_ADDRESSED">BEING_ADDRESSED</option>
          <option value="RESOLVED">RESOLVED</option>
        </select>
      </div>

      <table>
        <TableHeader header={header} />

        {filteredTickets.map((d) => {
          return (
            <tr>
              <Content data={d.ticketId} />
              <Content data={d.ticketType} />
              <Content data={d.status} />
              <Content data={d.ticketName} />
              <Content data={d.lastUpdateDate} />
              <td>
                <button>View</button>
              </td>
            </tr>
          );
        })}
      </table>
    </div>
  );
}

export default AllTickets;
