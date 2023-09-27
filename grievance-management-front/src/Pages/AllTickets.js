import React, { useEffect, useState } from "react";
import { allTicket, getTicketById } from "../api/Ticket_API";
import { Table } from "../components/Table/Table";
import "../css/Department.css";
import UpdateTicket from "./UpdateTicket";

function AllTickets() {
  const [ticket, setTicket] = useState([]);
  const [selectedStatus, setSelectedStatus] = useState("all");
  const [offset, setOffset] = useState(0);
  const [filter, setFilter] = useState("all");
  const [singleTicket, setSingleTicket] = useState();

  const [isUpdate, setUpdate] = useState(false);



  const params = {
    empid: Number(JSON.parse(localStorage?.getItem("user")).empId),
    ticket: filter,
    filter: selectedStatus,
    offset: offset,
  };

  const loadModel = (tick) => {
    getTicketById(tick.ticketId).then((resp) => {
     
      setSingleTicket(resp.data);
      setUpdate(true);
    });
  };
  useEffect(() => {
    allTicket(params).then((resp) => {
      setTicket(resp.data);
    });
  }, [offset, selectedStatus, filter, isUpdate]);

  const handleStatusChange = (e) => {
    setOffset(0);
    setSelectedStatus(e.target.value);
  };

  const handleFilterChange = (e) => {
    setOffset(0);
    setFilter(e.target.value);
  };

  const table = [
    { key: "ticketType", title: "Title" },
    { key: "depName", title: "Department" },
    { key: "status", title: "Status" },
    { key: "empName", title: "Assigned By" },
    { key: "lastUpdateDate", title: "Last Updated time" },
  ];

  return (
    <>
      {isUpdate && (
        <UpdateTicket
          singleTicket={singleTicket}
          setSingleTicket={setSingleTicket}
          setUpdate={setUpdate}
        />
      )}
      <div className="department-table">
        <div className="header-filter">
          <div className="header">
            <span>All Tickets</span>
          </div>
          <div className="filters">
            <div>
              <label>Status:</label>

              <select
                name="status"
                defaultValue="all"
                value={selectedStatus}
                onChange={handleStatusChange}
              >
                <option value="all">ALL TICKETS</option>
                <option value="open">OPEN</option>
                <option value="progress">BEING_ADDRESSED</option>
                <option value="resolved">RESOLVED</option>
              </select>
            </div>

            <div>
              <label>Ticket:</label>

              <select
                name="filter"
                defaultValue="all"
                value={filter}
                onChange={handleFilterChange}
              >
                <option value="all">ALL TICKETS</option>
                <option value="department">My Department</option>
                <option value="my">My Tickets</option>
              </select>
            </div>
          </div>
        </div>
        {ticket.length !== 0 ? (
          <div className="table-container">
            <Table data={ticket} columns={table} onRowClick={loadModel} />
          </div>
        ) : (
          <div table-container>
            <img src="nodata.png" alt="BigCo Inc. logo" />
            <h3>No ticket left !! GO BACK TO PREVIOUS PAGE</h3>
          </div>
        )}
        <div className="pre-next-button">
          {offset !== 0 && (
            <button
              disabled={offset === 0}
              onClick={() => {
                setOffset(offset - 1);
              }}
            >
              previous
            </button>
          )}
          {ticket.length !== 0 && (
            <button
              disabled={ticket.length === 0}
              onClick={() => {
                setOffset(offset + 1);
              }}
            >
              Next
            </button>
          )}
        </div>
      </div>
    </>
  );
}

export default AllTickets;
