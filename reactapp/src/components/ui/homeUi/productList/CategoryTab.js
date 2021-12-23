import React from 'react';

function CategoryTab({name, icon, id, handleTab}) {
    return ( 
        <li className="nav-item" role="presentation">
            <button className="nav-link" data-bs-toggle="tab" data-bs-target={name} type="button" value={id} onClick={handleTab}>{name}<img src={`assets/images/icons/${icon}`} alt={name} /></button>
        </li>
    );
}

export default CategoryTab;