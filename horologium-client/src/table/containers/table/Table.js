import React from 'react';

import TableHeader from '../../elements/common/table-header/TableHeader';
import TableBody from '../../elements/common/body/TableBody';

const Table = (props) => (
   <div>
      <table
         id={props.id}
         className={props.className || 'table table-striped table-bordered table-hover'}>
            <TableHeader
               columns={props.columns}
               filterableTable={props.filterableTable}
            />
         <TableBody
            dataList={props.dataList}
            keyFunction={props.keyFunction}
            onClickRow={props.onClickRow}
            selectOptions={props.selectOptions}
            emptyText={props.emptyText}
            paginationRow={props.paginationRow}
            columns={props.columns}
            readOnly={props.readOnly}
            getRowClassName={props.getRowClassName}
            addBtn={props.addBtn}
            additionalDataRow={props.additionalDataRow}
         />
      </table>
   </div>
);

export default Table;
