import React from 'react';
import { useNavigate } from 'react-router-dom';

function SizeList({ item }) {
  const navigate = useNavigate();
  const handleEdit = () => {
    console.log(item.id);
    navigate(`/addproductEdit/${item.id}`);
  };
  return (
    <tr>
      <td>{item.id}</td>
      <td>{item.sizeName}</td>
      <td>
        <button onClick={handleEdit}>edit</button>
      </td>
      <td>
        <button>del</button>
      </td>
    </tr>
  );
}

export default SizeList;
