package stagetime

class GeneralService {
    /**
     * Returns current time
     * @return current times
     */
    def static Date getTime(){
        TimeZone reference = TimeZone.getTimeZone("GMT")
        Calendar myCal = Calendar.getInstance(reference)
        TimeZone.setDefault(reference);
        return myCal.getTime()
    }

}
