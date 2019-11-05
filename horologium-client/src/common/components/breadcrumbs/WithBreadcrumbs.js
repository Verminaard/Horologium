import React, {Fragment} from 'react';
import Breadcrumbs from "./Breadcrumbs";

const WithBreadcrumbs = (props) => (
   <Fragment>
         <Breadcrumbs breadcrumbs={props.breadcrumbs} />
                  {props.children}
   </Fragment>
);
export default WithBreadcrumbs;
