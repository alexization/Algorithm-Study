class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        String[] temp = video_len.split(":");
        Integer totalSeconds = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        
        temp = pos.split(":");
        Integer posSeconds = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        
        temp = op_start.split(":");
        Integer opStartSeconds = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        
        temp = op_end.split(":");
        Integer opEndSeconds = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        
        if (posSeconds > opStartSeconds && posSeconds < opEndSeconds){
                posSeconds = opEndSeconds;
        }
        
        for (String cmd : commands){ 
            if (cmd.equals("next")){
                posSeconds += 10;
                if (posSeconds > totalSeconds){
                    posSeconds = totalSeconds;
                }
            } else {
                posSeconds -= 10;
                if (posSeconds < 0){
                    posSeconds = 0;
                }
            }
            if (posSeconds >= opStartSeconds && posSeconds <= opEndSeconds){
                posSeconds = opEndSeconds;
            }
        }
        
        Integer resultMin = posSeconds / 60;
        String resultMinString = resultMin + "";
        if (resultMin < 10){
            resultMinString = "0" + resultMinString;
        }
        Integer resultSecond = posSeconds % 60;
        String resultSecondString = resultSecond + "";
        if (resultSecond < 10){
            resultSecondString = "0" + resultSecondString;
        }
        answer = resultMinString + ":" + resultSecondString;
        return answer;
    }
}