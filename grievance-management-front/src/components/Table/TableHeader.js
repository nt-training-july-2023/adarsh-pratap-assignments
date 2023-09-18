import React from 'react'

function TableHeader(props) {
  const header = props.header;
  return (
    <tr>
        {header.map(data=>{
            return <th>{data}</th>
        })}
    </tr>
  )
}

export default TableHeader