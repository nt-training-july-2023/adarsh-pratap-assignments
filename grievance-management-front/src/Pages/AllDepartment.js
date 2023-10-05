import React, { useEffect, useState } from "react";
import { deleteDepartmentById, getAllDepartment } from "../api/Department_API";
import { Table } from "../components/Table/Table";
import PopUp from "../components/PopUp/PopUp";
import { getCurrentUserDetails } from "../Authentication/auth";
import { setPopUpDataInPopUp } from "../components/PopUp/SetPopUp";
import AddDepartment from "./AddDepartment";

function AllDepartment() {
  const [dep, setDep] = useState([]);

  const [offset, setOffset] = useState(0);
  const params = {
    offset: offset,
  };
  const setAllDepartment = () => {
    getAllDepartment(params).then((resp) => {
      setDep(resp.data);
    });
  };

  const [popUpData, setPopUpData] = useState();
  const handleDelete = (e) => {
    if (e.depName !== getCurrentUserDetails().depName) {
      deleteDepartmentById(e.depId).then((resp) => {
        const data = setPopUpDataInPopUp(
          "Department",
          "Deleted!!",
          "success-popup-message"
        );
        setPopUpData(data);
        setPopUp(true);
        setAllDepartment();
      });
    } else {
      const data = setPopUpDataInPopUp(
        "Department",
        "Can not delete own Department!!",
        "danger-popup-message"
      );
      setPopUpData(data);
      setPopUp(true);
    }
  };

  useEffect(() => {
    setAllDepartment();
  }, [offset]);

  const table = [
    { key: "depId", title: "Department ID" },
    { key: "depName", title: "Department Name" },
    { key: "delete", title: "Delete" },
  ];
  const [isModel, setIsModel] = useState(false);
  const [popUp, setPopUp] = useState(false);
  return (
    <>
      {isModel ? (
        <AddDepartment set={setIsModel} setDep={setAllDepartment} />
      ) : null}
      {popUp && <PopUp set={setPopUp} data={popUpData} />}
      <div className="department-table">
        <div className="header-filter">
          <div className="header">
            <span>All Department</span>
          </div>
          <div className="filters">
            <div>
              <button
                onClick={() => {
                  setIsModel(true);
                }}
              >
                + Add Department
              </button>
            </div>
          </div>
        </div>
        <div className="table-container">
          <Table
            data={dep}
            columns={table}
            onRowClick={() => {}}
            onDelete={handleDelete}
          />
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
          {dep.length === 10 && (
            <button
              disabled={dep.length === 0}
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

export default AllDepartment;
