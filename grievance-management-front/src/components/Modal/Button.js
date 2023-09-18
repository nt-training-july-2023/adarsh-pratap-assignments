import React from 'react'


function Button(props) {
  return (
    <div className={props.fields.className}>
                            <input type={props.fields.type} value={props.fields.value}  />
    </div>
  )
}

export default Button