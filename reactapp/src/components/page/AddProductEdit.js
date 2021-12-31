import axios from 'axios';
import React, { useEffect, useRef, useState } from 'react';
import { useParams } from 'react-router-dom';

function AddProductEdit() {
  const id = useParams();
  const sizeEditUrl = `http://localhost:8080/size/edit/${id}`;
  const sizeGetUrl = `httP://localhost:8080/size/find/${id}`;

  const [size, setSize] = useState({
    id: 0,
    sizeName: '',
  });

  const addProductInfo = (e) => {
    e.preventDefault();
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setSize({
      id: id,
      sizeName: e.target.value,
    });
  };

  useEffect(() => {
    axios.get(sizeGetUrl).then((Response) => {
      console.log(Response.data);
      setSize(Response.data);
    });
  }, [id]);

  return (
    <div className='container'>
      <div className='row col-6 m-auto'>
        <form onSubmit={addProductInfo}>
          <div className='col-12'>
            <label htmlFor='size' className='form-label'>
              size
            </label>
            <input
              type='text'
              className='form-control'
              id='sizeName'
              placeholder={size.sizeName}
              name='sizeName'
              required=''
              onChange={handleChange}
            />
          </div>

          <div className='text-center mt-5'>
            <button type='submit' className='btn btn-secondary'>
              submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default AddProductEdit;
