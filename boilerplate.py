import re

# file to be read (replace "list.txt" with your file name
infile = open("list.txt", "r")

# file to write to
outfile = open("result.txt", "w")

# traverse the file
for line in infile:
    match = re.search('', line) # match our regular expression
    '''
     at re.search('', line), replace '' 
     for  your regular expression
     
     http://pythex.org
     http://regexr.com
     for more information on regex
    '''
    if match is None: # no matches found
        continue
    else: # at least one match found
        target = match.group(0)
        ''' 
        at this point, our match is in our target var
        this is the perfect spot to massage our data
        by either snipping, appending, prepending or
        whatever
        '''
        print(target) # print values caught
        outfile.write(target+"\n") # write them to file
        
# close both files
outfile.close()
infile.close()
