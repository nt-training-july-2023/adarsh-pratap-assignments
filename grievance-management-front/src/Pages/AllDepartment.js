import React, { useEffect, useState } from "react";
import { deleteDepartmentById, getAllDepartment } from "../api/Department_API";
import { Table } from "../components/Table/Table";
import PopUp from "../components/PopUp";

function AllDepartment() {
  const [dep, setDep] = useState([]);

  const [offset, setOffset] = useState(0);
  const params ={
    offset:offset
  }
  const setAllDepartment = () => {
    getAllDepartment(params).then((resp) => {
      setDep(resp.data);
    });
  };

  const handleDelete = (e) => {
    deleteDepartmentById(e.depId).then((resp) => {
      setPopUp(true);
      setAllDepartment();
    });
  };

  useEffect(() => {
    setAllDepartment();
  },[offset]);

  const table = [{key:'depId',title:'Department ID'},{key:'depName',title:'Department Name'},{key:'delete',title:'Delete'}]

  const [popUp , setPopUp] = useState(false);
  return (
    <>
    {popUp && (<PopUp set={setPopUp} header={"Ticket"} message={"Deleted!!"} classname="danger-popup-message"/>)}
    <div className="department-table">
      <div className="header-filter">
          <div className="header-without-filter">
            <span>All Department</span>
          </div>
      </div>
      <div className="table-container">
      <Table data={dep} columns={table} onRowClick={()=>{}} onDelete={handleDelete}/>
      </div>
      <div className="pre-next-button">
          {offset !== 0 && (<button
            disabled={offset === 0}
            onClick={() => {
              setOffset(offset - 1);
            }}
          >
            previous
          </button>)}
          {dep.length !== 10 &&(<button
            disabled={dep.length === 0}
            onClick={() => {
              setOffset(offset + 1);
            }}
          >
            Next
          </button>)}
        </div>
    </div>
    </>
  );
}

export default AllDepartment;
