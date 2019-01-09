package com.logtables.LogTables;

public class ErrorDescription {
	private String errorMassage="";
	private String appName="";
	private Boolean type;
	private String errorCode;
	protected enum Severity {
		iconC, iconE, iconW
	}
	private Severity severity;


	public ErrorDescription(String error) {
		this.type=false;
		readAndProcessLineError(error);
		addToAppsErrCounters();
	}


	private void addToAppsErrCounters() {
		String appError="";
		
		//adding to appsErrCounters
		if(type)
			appError= appName + "1-" + errorCode;
		else
			appError= appName + "-" + errorCode;

		if(Start.appsErrCounters.containsKey(appError)) 
			Start.appsErrCounters.put(appError, Start.appsErrCounters.get(appError)+1);
		else
			Start.appsErrCounters.put(appError, 1);

		
		//initializing the severityErrorCounters counters
		if(!Start.severityErrorCounters.containsKey("critical")){
		Start.severityErrorCounters.put("critical", 0);
		Start.severityErrorCounters.put("error", 0);
		Start.severityErrorCounters.put("warning", 0);
		}
		
		
		// adding to appsErrorSeverityCounters & severityErrorCounters
		switch (severity) {
		case iconC:
			Start.severityErrorCounters.put("critical", Start.severityErrorCounters.get("critical") + 1 );
			appError=appError + " critical";
			break;
		case iconE:
			Start.severityErrorCounters.put("error", Start.severityErrorCounters.get("error")+1);
			appError=appError + " error";
			break;
		case iconW:
			Start.severityErrorCounters.put("warning",  Start.severityErrorCounters.get("warning") + 1 );
			appError=appError + " warning";
			break;
		}
		
		//adding to appsErrorSeverityCounters
		if(Start.appsErrorSeverityCounters.containsKey(appError)) 
			Start.appsErrorSeverityCounters.put(appError, Start.appsErrorSeverityCounters.get(appError)+1);
		else
			Start.appsErrorSeverityCounters.put(appError, 1);
		
	}


	private void readAndProcessLineError(String error) {
		String[] lineSplited=error.split(" ");
		int indexOfAppName=0;
		for(int i=0; i<lineSplited.length; i++) {
			if (lineSplited[i].startsWith("(") && lineSplited[i].endsWith(")")){
				indexOfAppName=error.indexOf(lineSplited[i]);
				int indexOfMinus=lineSplited[i].indexOf('-');

				//				int numOfDig=0;
				//				while(((int)(lineSplited[i].indexOf(indexOfMinus-1))) > 0  )
				this.appName=lineSplited[i].substring(1, indexOfMinus -1);
				//				System.out.println(appName);
				if(lineSplited[i].charAt(indexOfMinus -1 )=='1') {
					this.type=true;
				}


				int indexOfLast=lineSplited[i].indexOf(')');
				this.errorCode=lineSplited[i].substring(indexOfMinus+1, indexOfLast);

				int severityIndex=Integer.parseInt(errorCode)%10;
				if(severityIndex >= 1 && severityIndex <=3 )
					severity=Severity.iconC;
				else if(severityIndex >= 4 && severityIndex <= 6)
					severity=Severity.iconE;
				else
					severity=Severity.iconW;

			}
		}
		this.errorMassage=error.substring(11, indexOfAppName-2);

	}



	public String getErrorMassage() {
		return errorMassage;
	}


	public String getAppName() {
		return appName;
	}


	public Boolean getType() {
		return type;
	}


	public String getErrorCode() {
		return errorCode;
	}


	public Severity getSeverity() {
		return severity;
	}


	public void setSeverity(Severity severity) {
		this.severity = severity;
	}


}
