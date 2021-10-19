ghz --insecure --format=html --total=$1 --proto ./attendees.proto --call com.masteringapi.attendees.grpc.server.AttendeesService.getAttendees -d {} localhost:9090 > results.html
