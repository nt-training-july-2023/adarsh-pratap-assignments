import React, { useEffect, useState } from 'react'
import { getAllEmployee } from '../api/Employee_API';
import TableHeader from '../components/Table/TableHeader';
import Content from '../components/Table/Content';

function AllEmployees() {
  
  const [emp , setEmp] = useState([]);
  const [offset, setOffset] = useState(0);
  const params = {offset:offset};
  useEffect(()=>{
    getAllEmployee(params).then(resp=>{
        setEmp(resp.data);
    })
  },[offset])

  const header = ["Employee Name", "Email", "Department" , "Role" , "Actions"];
  return (
    <div className="department-table">
      <div className="header-filter">
          <div className="header">
            <span>All Employee</span>
          </div>
      </div>
      <div className="table-container">
      <table>
        <TableHeader header={header} />

        {emp.map((d) => {
          return (
            <tr>
              <Content data={d.userName} />
              <Content data={d.email} />
              <Content data={d.department.depName} />
              <Content data={d.role} />
              <td>
                {/* <button className="view-button" onClick={() => handleDelete(d.empId)}>Delete</button> */}
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
          {emp.length !== 0 &&(<button
            disabled={emp.length === 0}
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

export default AllEmployees