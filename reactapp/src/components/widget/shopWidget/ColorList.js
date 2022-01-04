import React from 'react';

function ColorList({item, check}) {
    console.log(item.id)
    return (
        <tr key = {item.id}>
        <td className='color_no'>{item.id}</td>
        <td className='color_name'>{item.colorName}</td>
        </tr>
     );
}

export default ColorList;