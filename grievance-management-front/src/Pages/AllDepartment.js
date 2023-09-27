import React, { useEffect, useState } from "react";
import { deleteDepartmentById, getAllDepartment } from "../api/Department_API";
import { Table } from "../components/Table/Table";

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
      setAllDepartment();
    });
  };

  useEffect(() => {
    setAllDepartment();
  },[offset]);

  const table = [{key:'depId',title:'Department ID'},{key:'depName',title:'Department Name'},{key:'delete',title:'Delete'}]

  return (
    <div className="department-table">
      <div className="header-filter">
          <div className="header">
            <span>All Department</span>
          </div>
      </div>
      <div className="table-container">
      {/* <table>
        <TableHeader header={header} />

        {dep.map((d) => {
          return (
            <tr>
              <Content data={d.depId} />
              <Content data={d.depName} />
              <td>
                <button className="view-button" onClick={() => handleDelete(d.depId)}>Delete</button>
              </td>
            </tr>
          );
        })}
      </table> */}
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
          {dep.length !== 0 &&(<button
            disabled={dep.length === 0}
            onClick={() => {
              setOffset(offset + 1);
            }}
          >
            Next
          </button>)}
        </div>
    </div>
  );
}

export default AllDepartment;
