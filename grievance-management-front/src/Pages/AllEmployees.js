import React, { useEffect, useState } from "react";
import { deleteEmployee, getAllEmployee } from "../api/Employee_API";
import { Table } from "../components/Table/Table";
import PopUp from "../components/PopUp";

function AllEmployees() {
  const [emp, setEmp] = useState([]);
  const [offset, setOffset] = useState(0);
  const params = { offset: offset };

  const getEmployee=()=>{
    getAllEmployee(params).then((resp) => {
      setEmp(resp.data);
    });
  }

  useEffect(() => {
    getEmployee();
  }, [offset]);


  const handleDelete=(user)=>{
    deleteEmployee(user.empId).then(resp=>{
      setPopUp(true);
      getEmployee();
    })
  }
  const table = [
    { key: "userName", title: "User Name" },
    { key: "email", title: "Email" },
    { key: "role", title: "Role" },
    { key: "depName", title: "Department" },
    {key:'delete',title:'Delete'}
  ];
  
  const [popUp, setPopUp] = useState(false)
  return (
    <>
    {popUp && (<PopUp set={setPopUp} header={"Ticket"} message={"Deleted!!"} classname="danger-popup-message"/>)}
    <div className="department-table">
      <div className="header-filter">
        <div className="header">
          <span>All Employee</span>
        </div>
      </div>
      <div className="table-container">
        <Table data={emp} columns={table} onRowClick={()=>{}} onDelete={handleDelete}/>
      </div>
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
        {emp.length !== 0 && (
          <button
            disabled={emp.length === 0}
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

export default AllEmployees;
