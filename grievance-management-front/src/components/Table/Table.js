export const Table= ({ data , columns , onRowClick , onDelete})=>{
    
    return (
        <table>
            <tr>
                {columns.map((column , index)=>(
                    <th key={index}>{column.title}</th>
                ))}
            </tr>
            {data.map((row)=> ( 
                <tr key={row.id} onClick={()=> onRowClick(row)}>
                    {columns.map((column)=>(
                        <td key={column.key}>{column.key.includes('.') //check if key include a dot  
                        ? column.key.split('.').reduce((obj, key) => obj[key], row) //if dot present then split it into array
                        : column.key === 'delete'? (<button className="view-button" onClick={()=>onDelete(row)}>Delete</button>) 
                        :row[column.key]}</td>  //then reduce the object key wise like first obj is row then first key then next and so on.
                    ))}
                </tr>
            ))}
        </table>
    )
};
