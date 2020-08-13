 select json_arrayagg(result.json) as json from (SELECT json_object(
               'date', date,
               'avg_response_time', avg(time),
               'total_request', (select count(request_in) as count from metrics ci where request_in=1 and ci.date = m.date group by request_in),
               'avg_response_time_api_calls', (select avg(time) as count from metrics co where request_in=0 and co.date = m.date group by request_in),
               'info_request', (select json_array(json_arrayagg(json_object('status_code', ir.code, 'count', ir.count))) as count
                                from (select code, count(code) as count
                                      from metrics cr where cr.date = m.date and cr.code is not null
                                      group by date, code) as ir)
           ) as json
FROM metrics m group by date) as result;