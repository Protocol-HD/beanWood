import React from 'react';

function SizeList({item, check}) {
    console.log(item.id)
    return (
        <tr key = {item.id}>
        <td className='size_no'>{item.id}</td>
        <td className='size_name'>{item.sizeName}</td>
        </tr>
     );
}

export default SizeList;