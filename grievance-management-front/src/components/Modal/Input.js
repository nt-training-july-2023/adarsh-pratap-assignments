import React from 'react'

function Input(props) {
  return (
    <div className={props.fields.className}>
                    <label>
                        {props.fields.label}
                    </label>
                    <input type={props.fields.type} name={props.fields.name} value={props.fields.value} placeholder={props.fields.placeholder} onChange={props.fields.onChange}/>
                    {props.fields.isValid && (<p>{props.fields.errorMessage}</p>)}
    </div>
  )
}

export default Input