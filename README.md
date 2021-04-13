# data-warehouse
Sample calls:
### Populating the database (assuming the command is executed in the same directory as data file)
curl -i -X POST localhost:8080//api-internal/v1/import/traffic-data -H "Content-Type: multipart/form-data" -F "file=@data.csv"
### Queries
Clicks for campaign in given time frame

curl -i "localhost:8080/api/v1/campaign-clicks?campaign=Mitgliedschaft+KiMi&from=2012-02-01&to=2021-02-02" -H "Content-Type: application/json"

Average ctr for a given campaign and datasource

curl -i "localhost:8080/api/v1/ctr?campaign=GDN_Retargeting&datasource=Google+Ads"
