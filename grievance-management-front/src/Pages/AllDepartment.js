import React, { useEffect, useState } from "react";
import TableHeader from "../components/Table/TableHeader";
import Content from "../components/Table/Content";
import { deleteDepartmentById, getAllDepartment } from "../api/Department_API";

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
    deleteDepartmentById(e).then((resp) => {
      alert(resp.data);
      setAllDepartment();
    });
  };

  useEffect(() => {
    setAllDepartment();
  }, [offset]);

  const header = ["Department Id", "Department Name", "Actions"];

  return (
    <div className="department-table">
      <div className="header-filter">
          <div className="header">
            <span>All Department</span>
          </div>
      </div>
      <div className="table-container">
      <table>
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
      </table>
      
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
