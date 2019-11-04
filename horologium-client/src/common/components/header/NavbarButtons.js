import PropTypes from 'prop-types';
import React from 'react';
import {Link} from "react-router-dom";
import classNames from 'classnames';

const NavbarButtons = ({navbarTabs}) => (
   <div className="collapse navbar-collapse" id="navbarSupportedContent">
      <ul className="navbar-nav mr-auto">
      {navbarTabs.map((button, index) =>
      <li className={classNames('nav-item', button.active && 'active')} key={index}>
         <Link to={button.href} className="nav-link">
            {button.label}
         </Link>
         </li>)}
      </ul>
   </div>
);

NavbarButtons.propTypes = {
   navbarTabs: PropTypes.array
};

export default NavbarButtons;
