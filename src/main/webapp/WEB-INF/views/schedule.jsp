<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<c:import url="/WEB-INF/views/layouts/main.jsp" />

<body>
    <jsp:include page="/WEB-INF/views/layouts/headerMenu.jsp">
        <jsp:param name="active" value="navSchedule" />
    </jsp:include>
    <div class="container">

        <p>${message}</p>

        <div id='calendar'></div>

        <jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>
    </div>

<script>

    $(document).ready(function() {

        $('#calendar').fullCalendar({
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            defaultDate: '2016-01-12',
            selectable: true,
            selectHelper: true,
            select: function(start, end) {
                var title = prompt('Event Title:');
                var eventData;
                if (title) {
                    eventData = {
                        title: title,
                        start: start,
                        end: end
                    };
                    $('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
                }
                $('#calendar').fullCalendar('unselect');
            },
            editable: false,
            eventLimit: true,
            displayEventTime: true,
            displayEventEnd: true,
            timezone: true,
            timeFormat: 'H:mm',
            events: [
                {
                    id: 1,
                    title: 'Tom',
                    start: '2016-01-09T07:00:00',
                    end: '2016-01-09T16:00:00',
                    allDay:false
                },
                {
                    id: 2,
                    title: 'Silvia',
                    start: '2016-01-16T04:00:00',
                    end: '2016-01-16T16:00:00'
                },
                {
                    id:3,
                    title: 'Sarah',
                    start: '2016-01-11T16:00:00',
                    end: '2016-01-12T10:00:00'
                },
                {
                    id: 4,
                    title: 'Tom',
                    start: '2016-01-22T05:00:00',
                    end: '2016-01-22T15:00:00'
                },
                {
                    id: 5,
                    title: 'Jerome',
                    start: '2016-01-20T16:00:00',
                    end: '2016-01-21T07:00:00'
                },
                {
                    id:6,
                    title: 'Sarah',
                    start: '2016-01-14T05:00:00',
                    end: '2016-01-14T12:00:00'
                },
                {
                    id: 7,
                    title: 'Tom',
                    start: '2016-01-23T10:00:00',
                    end: '2016-01-23T22:00:00'
                },
                {
                    id: 8,
                    title: 'Silvia',
                    start: '2016-01-25T16:00:00',
                    end: '2016-01-25T23:00:00'
                }
            ]
        });
    });

</script>

<link href='${contextPath}/resources/static/css/fullcalendar.css' rel='stylesheet' />
<link href='${contextPath}/resources/static/css/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='${contextPath}/resources/static/js/moment.min.js'></script>
<script src='${contextPath}/resources/static/js/fullcalendar.min.js'></script>

</body>
</html>