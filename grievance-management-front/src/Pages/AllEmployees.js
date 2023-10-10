import React, { useEffect, useState } from "react";
import { deleteEmployee, getAllEmployee } from "../api/Employee_API";
import { Table } from "../components/Table/Table";
import PopUp from "../components/PopUp/PopUp";
import { getCurrentUserDetails } from "../Authentication/auth";
import { setPopUpDataInPopUp } from "../components/PopUp/SetPopUp";
import { getAllDepartment } from "../api/Department_API";

function AllEmployees() {
  const [emp, setEmp] = useState([]);
  const [dep, setDep] = useState([]);
  const [offset, setOffset] = useState(0);
  const [departmentName, setDepartmentName] = useState("all");
  const params = { offset: offset, depName: departmentName };

  const getEmployee = () => {
    getAllEmployee(params).then((resp) => {
      setEmp(resp.data);
    });
  };

  const getDepartment = () => {
    getAllDepartment().then((resp) => {
      setDep(resp.data);
    });
  };

  useEffect(() => {
    getDepartment();
    getEmployee();
  }, [offset, departmentName]);

  const [popUpData, setPopUpData] = useState();

  const handleDelete = (user) => {
    if (user.empId !== getCurrentUserDetails().empId) {
      deleteEmployee(user.empId).then((resp) => {
        const data = setPopUpDataInPopUp(
          "Employee",
          "Deleted!!",
          "danger-popup-message"
        );
        setPopUpData(data);
        setPopUp(true);
        getEmployee();
      });
    } else {
      const data = setPopUpDataInPopUp(
        "Employee",
        "Can not delete your own data!!",
        "danger-popup-message"
      );
      setPopUpData(data);
      setPopUp(true);
    }
  };
  const table = [
    { key: "userName", title: "User Name" },
    { key: "email", title: "Email" },
    { key: "role", title: "Role" },
    { key: "depName", title: "Department" },
    { key: "delete", title: "Delete" },
  ];

  const handleDepartmentChange = (e) => {
    setOffset(0);
    setDepartmentName(e.target.value);
  };

  const [popUp, setPopUp] = useState(false);
  return (
    <>
      {popUp && <PopUp set={setPopUp} data={popUpData} />}
      <div className="department-table">
        <div className="header-filter">
          <div className="header">
            <span>All Employee</span>
          </div>

          <div className="filters">
            <div>
              <label>Department:</label>

              <select
                name="departmentName"
                value={departmentName}
                onChange={handleDepartmentChange}
              >
                <option value="all">All Department</option>
                {dep.map((d) => {
                  return (
                    <option key={d.depId} value={d.depName}>
                      {d.depName}
                    </option>
                  );
                })}
              </select>
            </div>
          </div>
        </div>
        {emp.length !== 0 ? (
          <div className="table-container">
            <Table
              data={emp}
              columns={table}
              onRowClick={() => {}}
              onDelete={handleDelete}
            />
          </div>
        ) : (
          <div className="table-container">
            <h3>No Employee Found!!</h3>
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
          {emp.length === 10 && (
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
