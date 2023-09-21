import React, { useEffect, useState } from "react";
import TableHeader from "../components/Table/TableHeader";
import Content from "../components/Table/Content";
import { deleteDepartmentById, getAllDepartment } from "../api/Department_API";

function AllDepartment() {
  const [dep, setDep] = useState([]);

  const setAllDepartment = () => {
    getAllDepartment().then((resp) => {
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
  }, []);

  const header = ["Department Id", "Department Name", "Actions"];

  return (
    <div className="department-table">
      <div>
        <h1>Add Department</h1>
      </div>
      <table>
        <TableHeader header={header} />

        {dep.map((d) => {
          return (
            <tr>
              <Content data={d.depId} />
              <Content data={d.depName} />
              <td>
                <button onClick={() => handleDelete(d.depId)}>Delete</button>
              </td>
            </tr>
          );
        })}
      </table>
    </div>
  );
}

export default AllDepartment;
